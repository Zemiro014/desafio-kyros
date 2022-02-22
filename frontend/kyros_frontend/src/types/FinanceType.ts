import { CategoryType } from "./CategoryType";

export type FinanceType = {
    id: string;
    description: string;
    financeType: string;
    value: string;
    status: string;
    dueData: string;
    paymentData: string;
    category: CategoryType;
}