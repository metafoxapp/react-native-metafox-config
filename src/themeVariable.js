import { configVariable } from './configVariable'

type ThemeVariable = {
  primaryColor: String,
  grayBaseColor: String,
}

export const themeVariable: ThemeVariable = Object.assign({
  primaryColor: '#2681D5',
  grayBaseColor: '#111111'
}, configVariable.themeVariable)
