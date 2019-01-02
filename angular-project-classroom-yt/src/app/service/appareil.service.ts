export class AppareilService {
  private appareils = [
    {
      id: 1,
      name: 'Machine à Laver',
      status: 'allumer'
    },

    {
      id: 2,
      name: 'Télévision',
      status: 'allumer'
    },

    {
      id: 3,
      name: 'Ordinateur',
      status: 'eteint'
    }

  ];

  getListAppareils() {
    return this.appareils;
  }

  getAppareilById(id: number) {
    return this.appareils.find(
      (app) => {
        return app.id === id;
      }
    );
  }

  switchOnAll() {
    this.appareils.forEach(function (app) {
      app.status = 'allumer';
    });
  }

  switchOffAll() {
    for (let appareil of this.appareils) {
      appareil.status = 'eteint';
    }
  }

  swicthOnOne(index: number) {
    this.appareils[index].status = 'allumer';
  }

  swicthOffOne(index: number) {
    this.appareils[index].status = 'eteint';
  }


}
