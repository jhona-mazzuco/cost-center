import {Component, OnInit} from '@angular/core';
import {CostService} from '../../../structure/services/cost.service';
import {DynamicDialogConfig, DynamicDialogRef, MessageService} from 'primeng';

@Component({
    selector: 'app-form-cost',
    templateUrl: './form-cost.component.html',
    styleUrls: ['./form-cost.component.scss']
})
export class FormCostComponent implements OnInit {

    entity: any;

    constructor(
        private service: CostService,
        private dialog: DynamicDialogRef,
        private message: MessageService,
        public config: DynamicDialogConfig
    ) {
        this.entity = {};
    }

    ngOnInit(): void {
        this.entity = {...this.config.data};
    }

    save() {
        this.service.save(this.entity)
            .then(() => {
                this.showMessage('Custo salvo com sucesso!', 'success');
                this.dialog.close();
            })
            .catch(({ error }) => this.showMessage(error, 'error'));
    }

    private showMessage(msg: string, severity: string) {
        this.message.add({
            severity: severity || null,
            detail: msg
        });
    }
}
