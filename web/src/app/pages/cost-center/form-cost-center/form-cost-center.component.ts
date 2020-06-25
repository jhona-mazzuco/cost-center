import {Component} from '@angular/core';
import {CostCenterService} from '../../../structure/services/cost-center.service';
import {CityService} from '../../../structure/services/city.service';
import {DynamicDialogRef, MessageService} from 'primeng';

@Component({
    selector: 'app-form-cost-center',
    templateUrl: './form-cost-center.component.html',
    styleUrls: ['./form-cost-center.component.scss']
})
export class FormCostCenterComponent {

    entity: any;
    suggestions: any[];

    constructor(
        private service: CostCenterService,
        private cityService: CityService,
        private message: MessageService,
        private dialog: DynamicDialogRef
    ) {
        this.entity = {};
        this.suggestions = [];
    }

    async search(event: any) {
        if ('query' in event) {
            this.suggestions = await this.cityService.search(event.query);
        }
    }

    save() {
        this.service.save(this.entity)
            .then(() => {
                this.showMessage('Custo salvo com sucesso!', 'success');
                this.dialog.close();
            })
            .catch(({error}) => this.showMessage(error, 'error'));
    }

    private showMessage(msg: string, severity: string) {
        this.message.add({
            severity: severity || null,
            detail: msg
        });
    }
}
