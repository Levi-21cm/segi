import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HurkaComponent } from './hurka.component';

describe('HurkaComponent', () => {
  let component: HurkaComponent;
  let fixture: ComponentFixture<HurkaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HurkaComponent]
    });
    fixture = TestBed.createComponent(HurkaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
