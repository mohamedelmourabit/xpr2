import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListColisComponent } from './list-colis.component';

describe('ListColisComponent', () => {
  let component: ListColisComponent;
  let fixture: ComponentFixture<ListColisComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListColisComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListColisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
