import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { SessionDetails } from '../dashboard/dashboard.component';
import { SessionService } from '../services/session.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  sessionForm = new FormGroup({
    Name: new FormControl("", [this.NameValidator.bind(this)]),
    InsName: new FormControl("", [this.sessionValidator.bind(this)]),
    desc: new FormControl("", [this.descValidator.bind(this)])
  })

  NameValidator(formControl: FormControl){
    if(!formControl.value){
      return { 'error': 'Required.'}
    }
  }

  sessionValidator(formControl: FormControl){
    if(!formControl.value){
      return { 'error': 'Required.'}
    }

  }

  descValidator(formControl: FormControl){
    if(!formControl.value){
      return { 'error': 'Required.'}
    }

  }

  addSession(){
    if(this.sessionForm.invalid)
    return

     let session: SessionDetails = new SessionDetails( undefined, this.sessionForm.controls.Name.value, this.sessionForm.controls.InsName.value
      , this.sessionForm.controls.desc.value)

     this.SessionService.AddCustomer(session).subscribe((response)=>{
       this.router.navigate(["/Dashboard"])
     })
  }

  constructor(private SessionService: SessionService, private router: Router) { }

  ngOnInit(): void {
  }

}
