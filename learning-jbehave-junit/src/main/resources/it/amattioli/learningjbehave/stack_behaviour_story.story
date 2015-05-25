Narrative:
In order to learn to with JBehave using Maven
As a junior BDD developer though senior in Java
I want to define the behavior of a custom stack

Scenario: I push an item onto the stack
Given I have an empty stack
When I push an item 'orange'
Then I should count 1

Scenario: I pop from the stack
Given I have an empty stack
When I push an item 'apple'
And I pop the stack
Then I should count 1
