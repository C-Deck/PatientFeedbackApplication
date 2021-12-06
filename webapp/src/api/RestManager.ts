import Axios, { AxiosInstance, AxiosRequestConfig } from 'axios'

// Helper class to handle rest calls
export class RestManager {
  private axiosInstance: AxiosInstance
  private baseURL: string

  public constructor(controllerURL: string) {
    const baseURL = `${controllerURL}`
    this.baseURL = baseURL
    this.axiosInstance = Axios.create({ baseURL })
    this.axiosInstance.interceptors.request.use((config) => {
      return this.addDefaultHeaders(config)
    })

    // Set the default timeout to 2 minutes
    this.axiosInstance.defaults.timeout = 120000
  }

  private addDefaultHeaders = (config: AxiosRequestConfig = {}) => {
    const headers = { ...config.headers }

    // Add in any headers that might be needed in the future here
    // None currently needed
    headers["Content-type"] = "application/json"

    return { ...config, headers }
  }

  public getBaseURL() {
    return this.baseURL
  }

  public async get<T = any>(url: string, config?: AxiosRequestConfig) {
    const response = await this.axiosInstance.get<T>(url, config)
    return response.data
  }

  public async post<T = any>(url: string, data: unknown, config?: AxiosRequestConfig) {
    const response = await this.axiosInstance.post<T>(url, data, config)
    return response.data
  }

  public async put<T = any>(url: string, data: unknown, config?: AxiosRequestConfig) {
    const response = await this.axiosInstance.put<T>(url, data, config)
    return response.data
  }

  public async delete(url: string, config?: AxiosRequestConfig) {
    await this.axiosInstance.delete(url, config)
  }
}