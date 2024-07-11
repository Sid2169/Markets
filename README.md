# Markets

Java command-line utilities for exploring profit-and-loss outcomes under a fixed risk model.

## Contents

- `PandL.java` — runs repeated simulations and reports minimum, maximum, and average returns.
- `SamplePandL.java` — prints a trade-by-trade sample using the same target, stop-loss, and win-rate inputs.

## Model

Each trade either gains the target percentage or loses the stop-loss percentage, chosen randomly according to the supplied win rate. `PandL.java` repeats the sequence for the requested number of samples to estimate the range of outcomes.

## Building

```sh
javac PandL.java SamplePandL.java
```

## Running

`PandL` expects six arguments in this order:

```sh
java PandL <profit-target-%> <stop-loss-%> <starting-capital> <trades> <win-rate-%> <samples>
```

Example:

```sh
java PandL 2 1 10000 100 55 1000
```

`SamplePandL` expects five arguments, omitting the sample count:

```sh
java SamplePandL 2 1 10000 100 55
```

## Notes

- All percentages are entered as whole numbers, e.g. `2` for 2%.
- The simulation uses `Math.random()`, so results vary between runs.
- Validate the argument count before relying on the output.

## Additional Notes

- **Java compilation** — Note any external service limits or required keys.
- **average return** — Keep commands copy-pasteable for new contributors.
- **minimum return** — Note any external service limits or required keys.
- **sample program** — Keep the related setup steps aligned with the current scripts.
- **win rate** — Document any manual steps that cannot be automated.
- **Monte Carlo sampling** — Prefer small, focused changes over broad rewrites.
- **maximum return** — Add a screenshot or example when it clarifies the workflow.
