import { Component, OnInit } from '@angular/core';
import { faStar, faPlus } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-search-box',
  templateUrl: './search-box.component.html',
})
export class SearchBoxComponent implements OnInit {

  public isActive: any;
  faPlus = faPlus;

  constructor() { }

  ngOnInit() {
  }

}
