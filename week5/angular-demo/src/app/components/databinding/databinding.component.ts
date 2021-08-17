import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-databinding',
  templateUrl: './databinding.component.html',
  styleUrls: ['./databinding.component.css']
})
export class DatabindingComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  someText: string = 'Kevin!';
  count:number = 0;
  countColor: string = 'blue-text';

  increment(){
    this.count += 1;
    this.someText = 'Joe';

    if(this.count%2 == 0){
      this.countColor = 'blue-text';
    } else {
      this.countColor = 'red-text';
    }
  }

}
