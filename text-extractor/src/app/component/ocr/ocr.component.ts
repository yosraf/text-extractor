import { Component, OnInit, ViewChild, ViewContainerRef, ComponentFactoryResolver } from '@angular/core';
import { OcrService } from 'src/app/service/ocr.service';
import { ResultComponent } from '../result/result.component';

@Component({
  selector: 'app-ocr',
  templateUrl: './ocr.component.html',
  styleUrls: ['./ocr.component.scss']
})
export class OcrComponent implements OnInit {
  file: File = null;
  loading = false;
  text: string;
  @ViewChild("result", { read: ViewContainerRef })
  result: ViewContainerRef;
  constructor(private service: OcrService, private componentFactoryResolver: ComponentFactoryResolver) { }

  ngOnInit(): void {
  }
  onChange(event) {
    this.loading = true;
    this.file = event.target.files[0];
    const reader = new FileReader();
    reader.readAsDataURL(this.file);
    reader.onload = () => {
      this.service.extractText(reader.result.toString()).subscribe((res: Object) => {
        this.loading = false;
        if (res["OCRExitCode"] === 1) {
          this.text = res['ParsedResults'][0]["ParsedText"];
          let resolver = this.componentFactoryResolver.resolveComponentFactory(ResultComponent);
          const resultComp = this.result.createComponent(resolver).instance;
          resultComp.text = this.text;
          resultComp.data = reader.result.toString();
        }

      });
    };
  }


}
