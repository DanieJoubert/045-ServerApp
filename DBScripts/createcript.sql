
CREATE DATABASE MessageStore;

USE [MessageStore]
GO

/****** Object:  Schema [msg]    Script Date: 2019/09/10 23:00:30 ******/
CREATE SCHEMA [msg]
GO

CREATE TABLE [msg].[Message](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Message] [varchar](255) NOT NULL,
	[Created_At] [date] NOT NULL,
 CONSTRAINT [PK_msg.Message] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [msg].[Message] ADD  DEFAULT (getdate()) FOR [Created_At]
GO


