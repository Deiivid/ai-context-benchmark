# SDD - Login token POC

## Scope

Build a local Android proof of concept with two screens:

- Login screen.
- Result screen.

The flow captures username and password text in memory and shows both values on the result screen after pressing the login button.

## Functional Requirements

### Login Screen

- Show top title: `Prueba de concepto de tokens`.
- Show main text: `Iniciar sesión`.
- Provide a text field for username.
- Provide a text field for password.
- Provide a button with text: `Iniciar sesión`.
- Pressing the button navigates to the result screen.

### Result Screen

- Show title: `Datos de inicio de sesión`.
- Show the username entered on the login screen.
- Show the password entered on the login screen.

## Non-Goals

- No real authentication.
- No backend.
- No encryption.
- No persistence.

## Design

- Implement the flow in Jetpack Compose.
- Keep credentials only in Compose state for the lifetime of the screen flow.
- Use simple in-memory navigation state instead of adding a navigation dependency.
- Use Android string resources for user-visible text.

## Acceptance Criteria

- App opens on the login screen.
- Entered username and password can be typed.
- Pressing `Iniciar sesión` displays the result screen.
- The result screen displays the exact values entered.
