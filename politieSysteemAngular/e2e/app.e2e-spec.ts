import { PolitieSysteemAngularPage } from './app.po';

describe('politie-systeem-angular App', function() {
  let page: PolitieSysteemAngularPage;

  beforeEach(() => {
    page = new PolitieSysteemAngularPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
