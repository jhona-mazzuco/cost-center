import {Injectable} from '@angular/core';
import {BaseService} from './base.service';
import {Restangular} from 'ngx-restangular';

@Injectable({
    providedIn: 'root'
})
export class CostService extends BaseService {

    constructor(restangular: Restangular) {
        super('cost', restangular);
    }

    save(entity: any) {
        return this.endpoint.customPOST(entity).toPromise();
    }

    remove(id: any) {
        return this.endpoint.one(`${id}`).remove().toPromise();
    }

    update(row: any) {
        return this.endpoint.one(`${row.id}`).customPUT(row).toPromise();
    }
}
