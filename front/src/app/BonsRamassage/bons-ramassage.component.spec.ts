import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BonsRamassageComponent } from './bons-ramassage.component';

describe('BonsRamassageComponent', () => {
  let component: BonsRamassageComponent;
  let fixture: ComponentFixture<BonsRamassageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BonsRamassageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BonsRamassageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
