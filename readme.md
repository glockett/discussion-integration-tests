#README

##Issues and Assumptions

1.  Test Registered user must have 'Staff Member" privileges in order to complete the automated tests. This is so we get around the limitation of only being able to add 1 comment per minute.

2.  Staff Members cannot 'Pick a comment' their own comment.

3.  Add a .gitignore file to project root.

4.  Add a local.conf file to the project root and paste the following, making changes where necessary:

        "browser": " add the browser to be used for tests here ie. firefox "
        "idApiRoot" : " add the Identity API root ie. https://idapi.code.dev-theguardian.com "
        
        "testBaseUrl": " add your testBaseURL here ie. http://m.code.dev-theguardian.com/ "
        
        "loginEmail" : " add your loginEmail here ie testuser@test.com "
        "loginPassword" : " add loginPassword ie. PASSWORD here "
        
        user: {
          "testArticlePath": " add the path to the Test article here ie. /science/grrlscientist/2012/aug/07/3 "
          
##How to run individual tests
Use this TAG to run individual tests - select:
    scenarioWeb("navigate through comment pages", Tag("WIP")) { ...

When running the test, in the menu "Run > Edit config " add the following to the Test Options: -n <TagName>  Then run the tests.