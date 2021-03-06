import { Injectable } from '@angular/core';
import { InMemoryDbService, RequestInfo } from 'angular-in-memory-web-api';
import { SessionDetails } from '../dashboard/dashboard.component';

@Injectable({
  providedIn: 'root'
})
export class dataStoreService implements InMemoryDbService {

  constructor() { }
  createDb() {
    let session = [
      new SessionDetails(1, "GAP Solid T-Shirt","A basic solid blue tshirt for your casual day out!", "$59.99"),
      new SessionDetails(2, "Nike Quick Dry Men Sports Shorts", "Made from breathable polyester material which will keep you going. ","$39.9"),
      new SessionDetails(3, "Product 3", "Description 3", "$XX.XX"),
      new SessionDetails(4, "Product 4", "Description 4", "$XX.XX" ),
      new SessionDetails(5,"Product 5", "Description 5", "$XX.XX"),
      new SessionDetails(6,"Product 6", "Description 6", "$XX.XX")
    ];
    return {session};
  }


  genId(session: SessionDetails[]): number {
    return session.length > 0 ? Math.max(...session.map(hero => hero.id)) + 1 : 4;
  }
}
