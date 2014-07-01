Issues and Assumptions:

1.  Test Registered user must have 'Staff Member" privileges in order to complete the automated tests. This is so we get around the limitation of only being able to add 1 comment per minute.

2.  Staff Members cannot 'Pick a comment' their own comment.

Evoke individual test:
Use this TAG to run individual tests - select scenarioWeb("navigate through comment pages", Tag("WIP")) { ...
When running the test, in the menu "Run > Edit config " add the following to the Test Options: -n <TagName>  Then run the tests.


