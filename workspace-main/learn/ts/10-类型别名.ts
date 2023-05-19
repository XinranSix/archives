export { }

type StrOrNum = string | number

let str: StrOrNum = '1'

type ObjType = {
    a: number & 2,
    b: string
}

let obj: ObjType = {
    a: 2,
    b: ''
}