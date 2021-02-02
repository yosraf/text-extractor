import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OcrService {

  constructor(private http:HttpClient) { }

  public  extractText(image:string): Observable<Object>{
    return this.http.post<Object>(environment.baseUrl + 'ocr/convert',image);
  }
}
