import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddColisComponent } from './add-colis.component';

describe('AddColisComponent', () => {
  let component: AddColisComponent;
  let fixture: ComponentFixture<AddColisComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddColisComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddColisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
