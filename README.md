# poker
Poker Hand Evaluator

## General Overview

### Run ExampleMain class to check examples provided in the task description.

### Run FileExampleMain class to check examples provided in 'poker.txt' file. Winner statistic is calculated here.

In general there are predefined rules and each player's cards are verified against those rules.
Verification result is stored in Hand object and later used in winner selection.

Rule can be simple like ('One Pair' or 'Highest Card') or composite (like 'Straight Flush').
Each rule has its own class with appropriate logic.

Enums were used because many things already predefined and not dynamically created during runtime.

Code is covered with tests. For some specific cases Mockito was used.
Apache Commons were used for utility operations too.
Maven is used as build tool.
  
