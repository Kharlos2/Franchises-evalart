terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = ">= 4.46.0"
    }
  }
}


provider "aws" {
  region     = var.aws_region
  profile    = var.profile
}