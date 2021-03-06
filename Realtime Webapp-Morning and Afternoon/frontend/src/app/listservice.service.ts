import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ListserviceService {

  constructor(private http: HttpClient) { }

  hello = () : Observable<any> => {
    return this.http.get<any>("/ordermgmt/hello");
  }
}
