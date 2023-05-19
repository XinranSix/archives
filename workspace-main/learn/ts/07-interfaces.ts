export { }

interface MyItf {
    name: string
    age: number
    height: number
}

let obj: MyItf

obj = {
    name: '张三',
    age: 18,
    height: 180
}

interface ArrItf {
    [index: number]: number | string
}

let arr: ArrItf = [1, 2, 3, "4", "5"]

interface FunItf {
    (p: string, a: number): void
}

let fn: FunItf = (p: string, a: number): void => {

}

fn('', 1)