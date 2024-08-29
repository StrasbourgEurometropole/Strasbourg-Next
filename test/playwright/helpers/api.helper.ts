import {APIRequestContext} from '@playwright/test';
import {CsmapApiHelper} from "./csmap.api.helper";

interface PostOptions<T> {
    data?: T;
    failOnStatusCode?: boolean;
    headers?: {[key: string]: string};
    multipart?: {[key: string]: any};
    form?: {[p: string]: string | number | boolean}
}

export class ApiHelpers {
    readonly request: APIRequestContext;
    readonly csmapApi: CsmapApiHelper;

    constructor(request: APIRequestContext) {
        this.request = request;
        this.csmapApi = new CsmapApiHelper(this);
    }

    async postResponse<T>(
        url: string,
        {data, failOnStatusCode, headers, multipart, form}: PostOptions<T> = {}
    ) {
        return await this.request.post(url, {
            data,
            form,
            failOnStatusCode: failOnStatusCode || false,
            headers: headers || (await this.getHeader()),
            multipart,
        });
    }

    async post<T>(url: string, options: PostOptions<T> = {}) {
        const response = await this.postResponse(url, options);

        if (response.status() === 204) {
            return;
        }

        return response.json();
    }

    async getResponse(
        url: string,
        failOnStatusCode?: boolean,
        headers?: {[key: string]: string}
    ) {
        return await this.request.get(url, {
            failOnStatusCode: failOnStatusCode || false,
            headers: headers || (await this.getHeader()),
        });
    }

    async put<T>(url: string, options: PostOptions<T> = {}) {
        const response = await this.putResponse(url, options);

        if (response.status() === 204) {
            return;
        }

        return response.json();
    }

    async putResponse<T>(
        url: string,
        {data, failOnStatusCode, headers, multipart, form}: PostOptions<T> = {}
    ) {
        return await this.request.put(url, {
            data,
            form,
            failOnStatusCode: failOnStatusCode || false,
            headers: headers || (await this.getHeader()),
            multipart,
        });
    }

    async delete(url: string, headers?: any) {
        return this.request.delete(url, {
            headers: {
                ...(await this.getHeader()),
                ...(headers || {}),
            },
        });
    }

    async get(
        url: string,
        failOnStatusCode?: boolean,
        headers?: {[key: string]: string}
    ) {
        const response = await this.getResponse(url, failOnStatusCode, headers);

        return response.json();
    }

    async getHeader() {
        return {

        };
    }
}
