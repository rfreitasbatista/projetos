import React from 'react';
<<<<<<< HEAD:src/tests/login.test.js
import { fireEvent } from '@testing-library/react';
=======
import { fireEvent, getByTestId, screen } from '@testing-library/react';
>>>>>>> test-rodrigo:src/__tests__/login.test.js
import Login from '../pages/Login/Login';
import renderWithRouter from '../services/renderWithRouter';
import Provider from '../contexts/Provider';

describe('Todos os elementos devem respeitar os atributos descritos no protótipo para a tela de login', () => {
  it('Tem os data-testids email-input, password-input e login-submit-btn', () => {
    const { getByTestId } = renderWithRouter(
      <Provider>
        <Login />
      </Provider>,
    );
    expect(getByTestId('email-input')).toBeInTheDocument();
    expect(getByTestId('password-input')).toBeInTheDocument();
    expect(getByTestId('login-submit-btn')).toBeInTheDocument();
  });
});

describe('A pessoa deve conseguir escrever seu email no input de email', () => {
  it('É possível escrever o email', () => {
    const { getByPlaceholderText } = renderWithRouter(
      <Provider>
        <Login />
<<<<<<< HEAD:src/tests/login.test.js
      </Provider>);
    const emailInput = getByPlaceholderText(/E-mail/i);
=======
      </Provider>,
    );
    const emailInput = getByLabelText(/E-mail:/i);
>>>>>>> test-rodrigo:src/__tests__/login.test.js
    fireEvent.change(emailInput, { target: { value: 'myemail@emailprovider.com' } });
    expect(emailInput.value).toBe('myemail@emailprovider.com');
  });
});

describe('A pessoa deve conseguir escrever sua senha no input de senha', () => {
  it('É possível escrever a senha', () => {
    const { getByPlaceholderText } = renderWithRouter(
      <Provider>
        <Login />
<<<<<<< HEAD:src/tests/login.test.js
      </Provider>);
    const passwordInput = getByPlaceholderText(/Senha/i);
=======
      </Provider>,
    );
    const passwordInput = getByLabelText(/Senha:/i);
>>>>>>> test-rodrigo:src/__tests__/login.test.js
    fireEvent.change(passwordInput, { target: { value: '12345678' } });
    expect(passwordInput.value).toBe('12345678');
  });
});

describe('O formulário só fica válido após um email válido e uma senha de mais de 6 caracteres serem preenchidos', () => {
  it('O botão deve estar desativado se o email for inválido', () => {
    const { getByRole, getByPlaceholderText } = renderWithRouter(
      <Provider>
        <Login />
      </Provider>,
    );
    const submitBtn = getByRole('button', { name: /Entrar/i });
    const emailInput = getByPlaceholderText(/E-mail/i);
    const passwordInput = getByPlaceholderText(/Senha/i);

    expect(submitBtn).toBeDisabled();

    fireEvent.change(emailInput, { target: { value: 'email@email' } });
    fireEvent.change(passwordInput, { target: { value: '1234567' } });
    expect(submitBtn).toBeDisabled();

    fireEvent.change(emailInput, { target: { value: 'email.com' } });
    expect(submitBtn).toBeDisabled();
  });

  it('O botão deve estar desativado se a senha deve tiver 6 caracteres ou menos', () => {
    const { getByRole, getByPlaceholderText } = renderWithRouter(
      <Provider>
        <Login />
      </Provider>,
    );
    const submitBtn = getByRole('button', { name: /Entrar/i });
    const emailInput = getByPlaceholderText(/E-mail/i);
    const passwordInput = getByPlaceholderText(/Senha/i);

    expect(submitBtn).toBeDisabled();

    fireEvent.change(emailInput, { target: { value: 'myemail@emailprovider.com' } });
    fireEvent.change(passwordInput, { target: { value: '1234' } });

    expect(submitBtn).toBeDisabled();
  });

  it('O botão deve estar ativado se o email e a senha forem válidos', () => {
    const { getByRole, getByPlaceholderText } = renderWithRouter(
      <Provider>
        <Login />
      </Provider>,
    );
    const submitBtn = getByRole('button', { name: /Entrar/i });
    const emailInput = getByPlaceholderText(/E-mail/i);
    const passwordInput = getByPlaceholderText(/Senha/i);

    expect(submitBtn).toBeDisabled();

    fireEvent.change(emailInput, { target: { value: 'myemail@emailprovider.com' } });
    fireEvent.change(passwordInput, { target: { value: '12345678' } });

    expect(submitBtn).toBeEnabled();
  });
});

describe('Após a submissão, 2 tokens devem ser salvos em localStorage identificados pelas chaves mealsToken e cocktailsToken', () => {
  it('Após a submissão mealsToken e cocktailsToken devem estar salvos em localStorage', () => {
    const { getByRole, getByPlaceholderText } = renderWithRouter(
      <Provider>
        <Login />
      </Provider>,
    );
    const submitBtn = getByRole('button', { name: /Entrar/i });
    const emailInput = getByPlaceholderText(/E-mail/i);
    const passwordInput = getByPlaceholderText(/Senha/i);

    expect(submitBtn).toBeDisabled();
    localStorage.clear();

    fireEvent.change(emailInput, { target: { value: 'myemail@emailprovider.com' } });
    fireEvent.change(passwordInput, { target: { value: '12345678' } });
    fireEvent.click(submitBtn);

    expect(localStorage.__STORE__['mealsToken']).toBe('1');
    expect(localStorage.__STORE__['cocktailsToken']).toBe('1');
  });
});

describe('Após a submissão, o e-mail de pessoa usuária deve ser salvo em localStorage na chave user', () => {
  it('Após a submissão a chave user deve estar salva em localStorage', () => {
<<<<<<< HEAD:src/tests/login.test.js
    const { getByRole, getByPlaceholderText } = renderWithRouter(
      <Provider>
        <Login />
      </Provider>);
    const submitBtn = getByRole('button', { name: /Entrar/i });
    const emailInput = getByPlaceholderText(/E-mail/i);
    const passwordInput = getByPlaceholderText(/Senha/i);
=======
    const { getByLabelText } = renderWithRouter(
      <Provider>
        <Login />
      </Provider>,
    );
    const submitBtn = screen.getByTestId('login-submit-btn');
    const emailInput = getByLabelText(/E-mail:/i);
    const passwordInput = getByLabelText(/Senha:/i);
>>>>>>> test-rodrigo:src/__tests__/login.test.js

    expect(submitBtn).toBeDisabled();
    localStorage.clear();

    fireEvent.change(emailInput, { target: { value: 'myemail@emailprovider.com' } });
    fireEvent.change(passwordInput, { target: { value: '12345678' } });
    fireEvent.click(submitBtn);
    const emailStorage = { email: 'myemail@emailprovider.com' };
    expect(JSON.parse(localStorage.__STORE__['user'])).toStrictEqual(emailStorage);
  });
});

describe('Após a submissão e validação com sucesso do login, o usuário deve ser redirecionado para a tela principal de receitas de comidas', () => {
  it('A rota muda para a tela principal de receitas de comidas', () => {
<<<<<<< HEAD:src/tests/login.test.js
    const { getByTestId, getByPlaceholderText, history } = renderWithRouter(
      <Provider>
        <Login />
      </Provider>);
    const submitBtn = getByTestId("login-submit-btn");
    const emailInput = getByPlaceholderText(/E-mail/i);
    const passwordInput = getByPlaceholderText(/Senha/i);
=======
    const { getByLabelText, getByTestId, history } = renderWithRouter(
      <Provider>
        <Login />
      </Provider>,
      { route: '/' },
    );
    localStorage.clear();
    const submitBtn = screen.getByTestId(/login-submit-btn/);
    const emailInput = getByLabelText(/E-mail:/i);
    const passwordInput = getByLabelText(/Senha:/i);
>>>>>>> test-rodrigo:src/__tests__/login.test.js

    expect(submitBtn).toBeDisabled();
    fireEvent.change(emailInput, { target: { value: 'myemail@emailprovider.com' } });
    fireEvent.change(passwordInput, { target: { value: '12345678' } });
    fireEvent.click(submitBtn);
<<<<<<< HEAD:src/tests/login.test.js
    const pathname = history.location.pathname;
    expect(pathname).toBe('/comidas')
=======
    const {
      location: { pathname },
    } = history;
    expect(pathname).toBe('/comidas');
>>>>>>> test-rodrigo:src/__tests__/login.test.js
  });
});

// referências:
// fireEvent de input: https://testing-library.com/docs/example-input-event
// lib pra testes jest com localStorage: https://www.npmjs.com/package/jest-localstorage-mock
