import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { OcrComponent } from './component/ocr/ocr.component';
import { HttpClientModule } from '@angular/common/http';
import { ResultComponent } from './component/result/result.component';


@NgModule({
  declarations: [
    AppComponent,
    OcrComponent,
    ResultComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
