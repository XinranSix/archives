// 创建 store 实例对象
import { observable, action } from 'mobx-miniprogram'

export const store = observable({
  numA: 1,
  numB: 2,
  get sum() {
    return this.numA + this.numB
  },
  updateNum1: action(function (step) {
    console.log(step);
    this.numA += step
  }),
  updateNum2: action(function (step) {
    this.numB += step
  }),
})