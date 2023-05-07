import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TokenInterceptorService implements HttpInterceptor{

  constructor() { }

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    let token:any = localStorage.getItem('token')
  if(token){
    // debugger
    request = request.clone({
      setHeaders: {
        Authorization: token
      }
   });
  }
    return next.handle(request);
  }
}
