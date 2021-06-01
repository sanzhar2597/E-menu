import {
  Directive,
  ElementRef,
  HostListener,
  Input,
  OnChanges,
  Renderer2,
  SimpleChange,
  SimpleChanges
} from '@angular/core';

@Directive({
  selector: '[appBoldDirective]'
})
export class BoldDirectiveDirective implements OnChanges {

  @Input() isClicked: boolean;

  constructor(private element: ElementRef,
              private renderer: Renderer2,
  ) {

    this.renderer.setStyle(this.element.nativeElement, 'cursor', 'pointer');
  }

  private COLOR_BLUE: string = 'green';
  private COLOR_TABLE: string = '#93549e';

  // isClicked: boolean = false

  /*@HostListener("click") onMouseEnter() {
    if(this.isClicked ){
      this.setFontWeight(this.COLOR_TABLE)
    }
    if(!this.isClicked ){
      this.setFontWeight(this.COLOR_BLUE)
    }
    // this.isClicked = !this.isClicked;
  }*/


  private setFontWeight(val: string) {
    this.renderer.setStyle(this.element.nativeElement, 'background-color', val);
  }

  ngOnChanges(changes: SimpleChanges): void {


    const is: SimpleChange = changes.isClicked;
    console.log('is:', is);

    if (!is.currentValue) {
      this.setFontWeight(this.COLOR_TABLE);
    }
    if (is.currentValue) {
      this.setFontWeight(this.COLOR_BLUE);
      this.renderer.setStyle(this.element.nativeElement, 'opacity', 0.8);

    }

    /*if (!fileId.firstChange && fileId.currentValue != fileId.previousValue) {
      this.holdImgFileId = fileId.currentValue;

      this.imgProvider.getFileById(this.fileId).then(res => {
        this.chosenPicture = res;
      }).catch(error => {
        this.presentToast("Error while loading picture.");
        console.error(error);
      });
    }*/

  }

}
