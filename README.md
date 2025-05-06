# mn_issue_json
Test project for showing an issue with json -> object conversion after upgrade of micronaut

Json conversion of classes with generics problem.

Run ProblemTest with micronaut version 4.8.2 or 4.7.6 in gradle.properties and it fails.
Run it with version 4.5.1 or 4.6.3 and it succeeds.
