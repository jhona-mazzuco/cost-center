import {Injectable} from '@angular/core';
import {BaseService} from './base.service';
import {Restangular} from 'ngx-restangular';

@Injectable({
    providedIn: 'root'
})
export class CostCenterService extends BaseService {

    constructor(restangular: Restangular) {
        super('cost-center', restangular);
    }

    findAll() {
        return this.endpoint.get().toPromise();
    }

    remove(id: number) {
        return this.endpoint.one(`${id}`).remove().toPromise();
    }

    getCosts(id: number) {
        return this.endpoint.one(`${id}`, 'costs').get().toPromise();
    }

    save(entity: any) {
        return this.endpoint.customPOST({ name: entity.name, city: entity.city.id }).toPromise();
    }

    getDashboard() {
        return this.endpoint.one('dashboard').get().toPromise();
    }
}
