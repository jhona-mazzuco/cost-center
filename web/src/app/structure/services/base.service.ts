import {Inject, Injectable} from '@angular/core';
import {Restangular} from 'ngx-restangular';

@Injectable({
    providedIn: 'root'
})
export class BaseService {

    constructor(@Inject(String) private url: string, private restangular: Restangular) {
    }

    get endpoint() {
        return this.restangular.one(this.url);
    }

}
