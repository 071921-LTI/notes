import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  people: string[] =[
    'Kevin',
    'Tim',
    'David',
    'Nick',
    'Alan'
  ];

  veryImportantBoolean: boolean = false;

  styles = {
    backgroundColor: "yellow",
    color: "red"
  }

  changeBoolean(){
    if(this.veryImportantBoolean){
      this.veryImportantBoolean = false;
    }else {
      this.veryImportantBoolean = true;
    }

    // this.veryImportantBoolean = !this.veryImportantBoolean;
  }
}
