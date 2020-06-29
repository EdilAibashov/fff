$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/homePage.feature");
formatter.feature({
  "name": "Home Page test",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@HomePage"
    }
  ]
});
formatter.scenario({
  "name": "Verify Account List Button",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@HomePage"
    },
    {
      "name": "@HomePage"
    },
    {
      "name": "@smoke"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@HomePageTest"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User opens Home home page",
  "keyword": "Given "
});
formatter.match({
  "location": "HomePage_STEPS.user_opens_Home_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify Page Title",
  "keyword": "When "
});
formatter.match({
  "location": "HomePage_STEPS.verify_Page_Title()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User navigate to Account List Button",
  "keyword": "And "
});
formatter.match({
  "location": "HomePage_STEPS.user_navigate_to_Account_List_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Open Your Orders Page",
  "keyword": "And "
});
formatter.match({
  "location": "HomePage_STEPS.open_Your_Orders_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verifies order page title",
  "keyword": "Then "
});
formatter.match({
  "location": "HomePage_STEPS.verifies_order_page_title()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});