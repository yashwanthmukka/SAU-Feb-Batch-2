import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {FilterCriteriaComponent} from '../filter-criteria/filter-criteria.component';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent implements OnInit {

  constructor(private dialog: MatDialog) { }

  ngOnInit(): void
  {
  }

  filterList(): void
  {
    this.dialog.open(FilterCriteriaComponent,{
      width: '300px'
    });
  }

}
