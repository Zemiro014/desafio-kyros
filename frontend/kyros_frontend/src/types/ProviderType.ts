import { AddressType } from "./AddressType";

export type ProviderType = {
    id: string;
    providerName: string;
    providerPhone: string;
    cnpjCpf: string;
    email: string;
    providerAddress: AddressType;
}