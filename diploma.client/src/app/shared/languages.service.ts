import {Injectable} from '@angular/core';
import {Languages} from "./languages";
import {Subject} from "rxjs/Subject";
import {BehaviorSubject} from "rxjs/BehaviorSubject";

@Injectable({
  providedIn: 'root'
})
export class LanguagesService {

  public CONST_LANGUAGES = {
    RU_LANGUAGE: 'ru',
    EN_LANGUAGE: 'en'
  };

  public languageChanged = new Subject<void>();

  public languages: any;
  public multiLanguage: Languages;
  private RU_LANGUAGE;
  private EN_LANGUAGE;

  constructor() {
    this.multiLanguage = new Languages();
    this.RU_LANGUAGE = this.multiLanguage.RU_LANGUAGE;
    this.EN_LANGUAGE = this.multiLanguage.EN_LANGUAGE;
    this.setDefaultLanguages();
    this.chooseLanguages()

  }

  setDefaultLanguages() {
    if (!localStorage.getItem('settings_language')) {
      console.log("LOCAL STORAGE : ", localStorage.getItem('settings_language'));
      localStorage.setItem('settings_language', this.CONST_LANGUAGES.RU_LANGUAGE);
    }
  }

  chooseLanguages() {
    let typeOfLanguages: string = localStorage.getItem("settings_language");
    try {
      switch (typeOfLanguages) {
        case this.CONST_LANGUAGES.RU_LANGUAGE:
          this.languages = this.RU_LANGUAGE;
          break;
        case this.CONST_LANGUAGES.EN_LANGUAGE:
          this.languages = this.EN_LANGUAGE;
          break;
        default:
          this.languages = this.RU_LANGUAGE;
          break;
      }
    }
    catch (e) {
      console.error("LANGUAGES DIDNT CHANGE ", e)
    }

  }

  changeLanguages(language: string) {
    localStorage.setItem('settings_language', language);
    this.chooseLanguages();
    this.languageChanged.next();


  };


}
