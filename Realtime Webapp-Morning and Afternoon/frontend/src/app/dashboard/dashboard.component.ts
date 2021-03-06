import { Component, OnInit } from '@angular/core';
import { SessionService } from '../services/session.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  SessionDetails: SessionDetails[] = [];
  SearchValue: string;

  constructor(private SessionService: SessionService) {

  }



  ngOnInit(): void {

    this.SessionService.getCustomers().subscribe((response : SessionDetails[])=>{
      console.log(response)
      this.SessionDetails = response;
    })
  }


  SearchChanges(val: string) {
    this.SessionDetails.forEach(element => {
      if (val) {
        (element.name.toLowerCase().includes(val.toLowerCase()) || element.desc.toLowerCase().includes(val.toLowerCase())
          || element.InsName.toLowerCase().includes(val.toLowerCase())) ? element.Visibility = true : element.Visibility = false;
      }
      else {
        element.Visibility = true;
      }
    });
  }
}


export class SessionDetails {
  id: number
  name: String
  InsName: string
  desc: string

  constructor(id: number, name: string, InsName: string, desc: string) {
    this.id = id;
    this.name = name;
    this.InsName = InsName;
    this.desc = desc
  }

  // UI behaviour
  Visibility: boolean = true

}
