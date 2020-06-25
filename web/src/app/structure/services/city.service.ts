import {Injectable} from '@angular/core';
import {BaseService} from './base.service';
import {Restangular} from 'ngx-restangular';

@Injectable({
    providedIn: 'root'
})
export class CityService extends BaseService {

    constructor(restangular: Restangular) {
        super('city', restangular);
    }

    search(name: string) {
        return this.endpoint.one('search').get({ search: name }).toPromise();
    }
}
