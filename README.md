# Cards Project
# Description

Consider this description as a business task description in Jira. All the analysis was done by system
analyst and following description was created.
Bank company want to start issuing cards to their customers. System analyst found out that there will
be a contract which will have objects (e.g. a Customer) and that objects will have sub-objects (e.g. card
types such as Debit or Credit or PrePaid and etc...).
One contract can contain multiple objects (e.g. family contract where Father, Mother and Kids has bank
cards.). One object can contain multiple sub-objects (e.g. Father can have Debit and Credit card, Kids
can have PrePaid and Debit and etc...).
In this iteration, client needs a functionality that calculates premium (a price that will be paid by each
client that will buy card insurance) for the contract.
Premium is calculated by a formula defined in “Required functionality” section.
In short - formula groups all sub-objects by their type, sums their sum-insured and applies coefficient
to the sum.
