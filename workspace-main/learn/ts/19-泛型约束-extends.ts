export { }

type StrOrNum = string | number

interface PersonItf<N extends StrOrNum, G> {
    name: N,
    getName: () => G
}

let obj: PersonItf<string, number> = {
    name: '1',
    getName() {
        return 1
    }
}