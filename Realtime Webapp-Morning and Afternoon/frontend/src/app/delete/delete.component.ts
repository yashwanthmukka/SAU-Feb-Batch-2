import { Component, OnInit } from '@angular/core';
import { SessionService } from '../services/session.service';
import { Router, RouterState, RouterLink, ActivatedRoute } from '@angular/router';
import { SessionDetails } from '../dashboard/dashboard.component';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  selectedSessionDetails

  constructor(private SessionService: SessionService, private activateRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    let id = this.activateRoute.snapshot.params['id']
    this.SessionService.getCusomterById(id).subscribe((response: SessionDetails)=>{
      console.log(response)
      this.selectedSessionDetails = response;
    })
  }

  OnDeletesessionConfirm(){

    this.SessionService.deletesession(this.selectedSessionDetails.id).subscribe((response)=>{
      console.log(response)
      this.router.navigate(['Dashboard'])
    })
  }

}
