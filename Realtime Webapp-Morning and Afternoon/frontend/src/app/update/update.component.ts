import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { SessionService } from '../services/session.service';
import { Router, ActivatedRoute } from '@angular/router';
import { SessionDetails } from '../dashboard/dashboard.component';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {


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

  selectedsession: SessionDetails;

  constructor(private SessionService: SessionService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {

    this.SessionService.getCusomterById(this.activatedRoute.snapshot.params['id']).subscribe((response: SessionDetails)=>{
      this.selectedsession = response
      console.log(this.selectedsession)

      this.sessionForm.controls.Name.setValue(this.selectedsession.name)
      this.sessionForm.controls.InsName.setValue(this.selectedsession.desc)
      this.sessionForm.controls.desc.setValue(this.selectedsession.InsName)
    })
  }

  OnUpdate(){
    this.selectedsession.name = this.sessionForm.controls.Name.value
    this.selectedsession.InsName = this.sessionForm.controls.InsName.value
    this.selectedsession.desc =  this.sessionForm.controls.desc.value
    this.SessionService.updatesession(this.selectedsession).subscribe(()=>{
      this.router.navigate(["Dashboard"])
    })

  }
}
