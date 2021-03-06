import { TestBed } from '@angular/core/testing';

import { dataStoreService } from './dataStore.service';

describe('dataStoreService', () => {
  let service: dataStoreService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(dataStoreService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
