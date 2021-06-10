import { Component, ElementRef, Inject, OnInit, Renderer2 } from '@angular/core';
import { LanguagesService } from '../shared/languages.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';
import { BookingService } from '../shared/booking.service';

@Component({
  selector: 'app-table-selection',
  templateUrl: './table-selection.component.html',
  styleUrls: ['./table-selection.component.css']
})
export class TableSelectionComponent implements OnInit {

  public selectedItem: any = {};
  public selectedId: number;

  constructor(@Inject(MAT_DIALOG_DATA) public data,
              public dialogRef: MatDialogRef<TableSelectionComponent>,
              private bookingService: BookingService,
              public languagesService: LanguagesService,
              private el: ElementRef,
              private renderer: Renderer2
  ) {
  }

  public staticTable = {
    'table-part-left': [
      {
        name: 'place-1',
        enable: false,
      },
      {
        name: 'place-5',
        enable: false,

      },
      {
        name: 'place-9',
        enable: false,
      },
      {
        name: 'place-13',
        enable: false,
      },
      {
        name: 'place-17',
        enable: false,
      },
      {
        name: 'place-21',
        enable: false,

      },
      {
        name: 'place-23',
        enable: false,
      },
      {
        name: 'place-25',
        enable: false,
      },
      {
        name: 'place-29',
        enable: false,
      },
      {
        name: 'place-33',

        enable: false,
      },
      {
        name: 'place-37',
        enable: false,

      },
      {
        name: 'place-41',
        enable: false,

      },
      {
        name: 'place-45',
        enable: false,

      },
    ],
    'table-part-center-left': [
      {
        name: 'place-2',
        enable: false,

      },
      {
        name: 'place-6',
        enable: false,

      },
      {
        name: 'place-10',
        enable: false,

      },
      {
        name: 'place-14',
        enable: false,

      },
      {
        name: 'place-18',
        enable: true,
      },
      {
        name: 'place-22',
        enable: true,
      },
      {
        name: 'place-24',
        enable: true,
      },
      {
        name: 'place-26',
        enable: true,
      },
      {
        name: 'place-30',
        enable: true,
      },
      {
        name: 'place-34',
        enable: true,
      },
      {
        name: 'place-38',
        enable: true,
      },
      {
        name: 'place-42',
        enable: true,
      },
      {
        name: 'place-46',
        enable: true,
      },
    ],
    'table-part-center': [
      {
        name: 'place-3',
        enable: true,
      },
      {
        name: 'place-7',
        enable: true,
      },
      {
        name: 'place-11',
        enable: true,
      },
      {
        name: 'place-15',
        enable: true,
      },
      {
        name: 'place-19',
        enable: true,
      },
      {
        name: 'place-27',
        enable: true,
      },
      {
        name: 'place-31',
        enable: true,
      },
      {
        name: 'place-35',
        enable: true,
      },
      {
        name: 'place-39',
        enable: true,
      },
      {
        name: 'place-43',
        enable: true,
      }


    ],
    'table-part-up': [
      {
        name: 'place-4',
        enable: false,
      },
      {
        name: 'place-8',
        enable: false,
      },
      {
        name: 'place-12',
        enable: false,
      },
      {
        name: 'place-16',
        enable: false,
      },
      {
        name: 'place-20',
        enable: false,
      },
      {
        name: 'place-28',
        enable: false,
      },
      {
        name: 'place-32',
        enable: false,
      },
      {
        name: 'place-36',
        enable: true,
      },
      {
        name: 'place-40',
        enable: true,
      },
      {
        name: 'place-44',
        enable: true,
      }
    ],
    'table-part-right': [
      {
        name: 'place-47',
        enable: true,
      },
      {
        name: 'place-48',
        enable: true,
      },
      {
        name: 'place-49',
        enable: true,
      }

    ],

  };


  keys(): Array<string> {
    return Object.keys(this.staticTable);
  }

  createstaticTable() {

    let findTableItem = 0;
    for (let key in this.staticTable) {
      for (let item in this.staticTable[key]) {
        for (let tab in this.data.tableArray) {
          if (this.data.tableArray[tab].name == this.staticTable[key][item].name) {
            this.staticTable[key][item].enable = true;
            this.staticTable[key][item].personNumber = this.data.tableArray[tab].personNumber;
          }
        }
        if (findTableItem == this.data.response) {
          this.selectedItem = this.staticTable[key][item];
        }
        this.staticTable[key][item].id = findTableItem++;

      }
    }
  }

  ngOnInit() {
    this.createstaticTable();
  }


  chooseTable(item: any) {
    let answerBack: any;
    this.selectedItem = item;
    if (this.selectedItem.enable) {

      setTimeout(() => {
        this.dialogRef.close(this.selectedItem);

      }, 200);
    }
  }

}
