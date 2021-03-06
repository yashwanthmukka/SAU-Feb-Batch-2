import {Component, Inject, OnInit} from '@angular/core';
import {FilterComponent} from '../filter/filter.component';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-filter-criteria',
  templateUrl: './filter-criteria.component.html',
  styleUrls: ['./filter-criteria.component.css']
})
export class FilterCriteriaComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) private dialogRef: MatDialogRef<FilterComponent>) { }

  ngOnInit(): void {
  }

}
