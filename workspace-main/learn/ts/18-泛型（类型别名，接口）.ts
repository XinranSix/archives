export { }

type StrOrNum = string | number

type ObjType<T, G=number> = {
    name: T,
    getName: () => G
}

let obj: ObjType<StrOrNum> = {
    name: '',
    getName() {
        return 1
    }
}

interface PersonItf<T, S> {
    name: T
    getName: () => S
}

let obj2: PersonItf<string, string> = {
    name: '张三',
    getName() {
        return ''
    }
}