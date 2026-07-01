# TDD - Login token POC

## Implementation Plan

- Replace the default greeting UI with a two-screen Compose flow.
- Add string resources for all visible labels required by the scenario.
- Keep username and password in local Compose state.
- Switch from login to result using an internal screen state.
- Add Compose UI tests for initial rendering and value handoff to the result screen.

## Components

### `LoginTokenApp`

Root composable that owns:

- Current screen state.
- Username value.
- Password value.

### `LoginScreen`

Displays:

- Top title.
- Login heading.
- Username text field.
- Password text field.
- Login button.

Events:

- Username changes update root state.
- Password changes update root state.
- Login button changes current screen to result.

### `ResultScreen`

Displays:

- Result title.
- Username value.
- Password value.

## Testing

Use Compose UI tests where available:

- Verify login screen renders required static text.
- Type username and password.
- Press login.
- Verify result screen renders both typed values.

## Validation

Minimum practical validation:

- Compile debug app.
- Compile Android instrumentation tests.
