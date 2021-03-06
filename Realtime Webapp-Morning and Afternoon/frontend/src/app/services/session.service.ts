import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SessionDetails } from '../dashboard/dashboard.component';
import { catchError, map, tap } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { dataStoreService } from './dataStore.service';

@Injectable({
  providedIn: 'root'
})
export class SessionService {



  constructor(private httpClient: HttpClient) { }


  getCustomers(): Observable<SessionDetails[]>{
    let url = `${environment.baseUrl}session`
    return this.httpClient.get<SessionDetails[]>(url).pipe(
      catchError(this.handleError<SessionDetails[]>('getsessions', []))
    );
  }

  AddCustomer(SessionDetails: SessionDetails){
    let url = `${environment.baseUrl}session`
    return this.httpClient.post<SessionDetails>(url, SessionDetails).pipe(
      catchError(this.handleError<SessionDetails[]>('addsession', []))
    );
  }

  getCusomterById(id: number): Observable<SessionDetails>{
    let url = `${environment.baseUrl}session/${id}`
    return this.httpClient.get<SessionDetails>(url).pipe(
      catchError(this.handleError<SessionDetails>('getCusomterById', undefined))
    );
  }

  deletesession(id: number){
    let url = `${environment.baseUrl}session/${id}`
    return this.httpClient.delete<SessionDetails>(url).pipe(
      catchError(this.handleError<SessionDetails[]>('addsession', []))
    );
  }

  updatesession(SessionDetails: SessionDetails){
    let url = `${environment.baseUrl}session`
    return this.httpClient.post<SessionDetails>(url, SessionDetails).pipe(
      catchError(this.handleError<SessionDetails[]>('addsession', []))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }

}
